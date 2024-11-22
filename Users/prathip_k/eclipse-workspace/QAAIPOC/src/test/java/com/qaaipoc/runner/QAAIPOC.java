package com.qaaipoc.runner;

import org.testng.annotations.Test;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.apache.http.entity.StringEntity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qaaipoc.utlities.ExcelReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.Writer;


import okhttp3.*;
import java.io.IOException;
import java.util.Base64;

public class QAAIPOC extends ExcelReader {

    private static String JIRA_URL, USER_EMAIL, JIRA_API_TOKEN, OPENAI_URL, OPENAI_API_TOKEN, OPENAI_TC_PROMPT,
            OPENAI_AI_CODE_PROMPT, JIRA_ID;
    static ExcelReader reader = new ExcelReader();

    private static final String GITHUB_API_URL = "https://api.github.com";
    private static final String REPO_OWNER = "pradeep021984";  // Replace with the repo owner
    private static final String REPO_NAME = "AITEST";  // Replace with the repository name
    private static final String ACCESS_TOKEN = "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";  // Replace with your GitHub token

    @Test
    private void runAIPOC() throws Exception {

        System.out.println("Sample Test");
//		String filePath = "Users/prathip_k/eclipse-workspace/QAAIPOC/src/test/java/com/qaaipoc/runner/QAAIPOC.java";  // Replace with the file path
//	       String fileContent = "Hello, GitHub!";     // Replace with the content of the file
//	       String commitMessage = "Upload file via API";
//
//	       uploadFileToGitHub(filePath, fileContent, commitMessage);


        getDataFromExcel();
        String userStory = getJIRAValues(JIRA_ID);
        if (!userStory.contains("ERROR")) {
            System.out.println("Writing feature file for  '" + JIRA_ID + "' - " + strbasePath + "/src/test/resources/feature/");
            String testCases = openAI(OPENAI_TC_PROMPT + " \"" + userStory + "\"");

            testCases= testCases.replaceAll("gherkin", "").replaceAll("#", "").replace("`", "");
            writeToFile(strbasePath + "/src/test/resources/feature/", JIRA_ID + ".feature", testCases);
            uploadFileToGitHub(strbasePath.substring(1) +"/src/test/resources/feature/" + JIRA_ID + ".feature",testCases,"Uploaded from AI Script");

            System.out.println("Generating Automation Code");
            String txtCode = openAI(OPENAI_AI_CODE_PROMPT + " \"" + testCases + "\"").replace("```gherkin", "")
                    .replace("```java", "");

            createFiles(txtCode);
            System.out.println("Execution is Completed! Pls check output folder");
        }


    }

    public static String getJIRAValues(String issueKey) throws ClientProtocolException, IOException {
        StringBuilder userStory = new StringBuilder();
        try {
            String issueSummary, issueDescription, textOutput = "";

            System.out.println("Reading '" + JIRA_ID + "' User Story from JIRA");

            String auth = USER_EMAIL + ":" + JIRA_API_TOKEN;
            byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.ISO_8859_1));
            String authHeader = "Basic " + new String(encodedAuth);

            CloseableHttpClient client = HttpClients.createDefault();

            HttpGet httpGet = new HttpGet(JIRA_URL + issueKey);
            httpGet.setHeader("Authorization", authHeader);
            httpGet.setHeader("Accept", "application/json");

            HttpResponse response = client.execute(httpGet);
            HttpEntity responseEntity = response.getEntity();
            String result = EntityUtils.toString(responseEntity);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(result);
            issueSummary = jsonNode.get("fields").get("summary").asText();
            issueDescription = jsonNode.get("fields").get("description").toPrettyString();
            client.close();

            JSONObject jsonObjectContent = new JSONObject(issueDescription);
            JSONArray arrContent = jsonObjectContent.getJSONArray("content");
            for (int intContent = 0; intContent < arrContent.length(); intContent++) {
                textOutput = "";
                JSONObject jsonObjectSubContent = arrContent.getJSONObject(intContent);
                JSONArray arrSubContent = jsonObjectSubContent.getJSONArray("content");
                for (int intSubContent = 0; intSubContent < arrSubContent.length(); intSubContent++) {
                    JSONObject jsonobjectText = arrSubContent.getJSONObject(intSubContent);
                    if (jsonobjectText.has("text")) {
                        textOutput = textOutput + " " + jsonobjectText.getString("text");
                    }

                }
                userStory.append(textOutput.trim());
            }

            return (userStory.toString());

        } catch (Exception e) {
            userStory.append("ERROR");
            userStory.append(e.getMessage());
            return (userStory.toString());
        }
    }

    public static String openAI(String text) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(OPENAI_URL);
        httpPost.setHeader("Content-Type", "application/json");

        Map<String, Object> contents = new HashMap<>();
        Map<String, Object> parts = new HashMap<>();
        Map<String, Object> part = new HashMap<>();

        part.put("text", text);
        parts.put("parts", new Object[] { part });
        contents.put("contents", new Object[] { parts });

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(contents);

        HttpEntity stringEntity = new StringEntity(jsonRequest);
        httpPost.setEntity(stringEntity);

        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();

        String responseString = EntityUtils.toString(responseEntity);

        JsonNode jsonResponse = objectMapper.readTree(responseString);

        String assistantReply = jsonResponse.get("candidates").get(0).get("content").get("parts").get(0).get("text")
                .asText();

        httpClient.close();
        return assistantReply;
    }

    private static void getDataFromExcel() throws InvalidFormatException, IOException {
        List<Map<String, String>> data = reader.getData(SheetPath, "POC");
        JIRA_URL = data.get(0).get("JiraUrl");
        USER_EMAIL = data.get(0).get("UserEmail");
        JIRA_API_TOKEN = data.get(0).get("JiraAPIToken");
        OPENAI_API_TOKEN = data.get(0).get("OpenAIAPIToken");
        OPENAI_URL = data.get(0).get("OpenAIUrl") + OPENAI_API_TOKEN;
        OPENAI_TC_PROMPT = data.get(0).get("OpenAITCPrompt");
        OPENAI_AI_CODE_PROMPT = data.get(0).get("OpenAITCodePrompt");
        JIRA_ID = data.get(0).get("JiraID");
    }

    private static void writeToFile(String folderPath, String fileName, String testToWrite) {
        try {
            File filePath = new File(folderPath + fileName);
            boolean result = Files.deleteIfExists(filePath.toPath());
            FileOutputStream opStream = new FileOutputStream(filePath);
            OutputStreamWriter opsWriter = new OutputStreamWriter(opStream);
            Writer bufWritter = new BufferedWriter(opsWriter);
            bufWritter.write(testToWrite);
            bufWritter.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
    }

    public static void createFiles(String txtOutput) throws IOException {
        String pomFile, featureFile, stepFile,firstLine;
        String[] arrOutput = txtOutput.split("class ");
        stepFile=arrOutput[0] + " class " + arrOutput[1];
        pomFile="class " + arrOutput[2];


        System.out.println("Writing Step Definition for  '" + JIRA_ID + "' - " + strbasePath + "/src/test/java/com/qaaipoc/stepDefinition/");
        writeToFile(strbasePath +"/src/test/java/com/qaaipoc/stepDefinition/", JIRA_ID + "_StepDefinition.java",
                stepFile);
        uploadFileToGitHub(strbasePath.substring(1) +"/src/test/java/com/qaaipoc/stepDefinition/" + JIRA_ID + "_StepDefinition.java",stepFile,"Uploaded from AI Script");

        System.out.println("Writing POM file for  '" + JIRA_ID + "' - " + strbasePath + "/src/test/java/com/qaaipoc/pageObject/");
        writeToFile(strbasePath +"/src/test/java/com/qaaipoc/pageObject/", JIRA_ID + "_Page.java", pomFile);
        uploadFileToGitHub(strbasePath.substring(1) +"/src/test/java/com/qaaipoc/pageObject/" + JIRA_ID + "_Page.java",pomFile,"Uploaded from AI Script");
    }


    public static void createFiles_old(String txtOutput) {
        String pomFile, featureFile, stepFile,firstLine;
        featureFile = txtOutput.split("Feature File")[1].split("`")[0].toString();
        String featureName = txtOutput.substring(0, txtOutput.indexOf("\n")).replace(":", "").replace(" ", "")
                .replace("##", "");
        firstLine = featureFile.substring(0, featureFile.indexOf("\n"));
        featureFile=featureFile.replace(firstLine, "");

        stepFile = txtOutput.split("Step Definition")[1].split("`")[0].toString();
        firstLine = stepFile.substring(0, stepFile.indexOf("\n"));
        stepFile=stepFile.replace(firstLine, "");


        if (txtOutput.contains("POM")) {
            pomFile = txtOutput.split("POM")[1].split("`")[0].toString();
            firstLine = pomFile.substring(0, pomFile.indexOf("\n"));
            pomFile=pomFile.replace(firstLine, "");
        } else {
            pomFile = txtOutput.split("Page Object Model")[1].split("`")[0].toString();
            firstLine = pomFile.substring(0, pomFile.indexOf("\n"));
            pomFile=pomFile.replace(firstLine, "");
        }



        System.out.println("Writing Step Definition for  '" + JIRA_ID + "' - " + strbasePath + "/src/test/resources/feature/");
        writeToFile(strbasePath +"/src/test/java/com/qaaipoc/stepDefinition/", JIRA_ID + "_StepDefinition.java",
                stepFile);

        System.out.println("Writing POM file for  '" + JIRA_ID + "' - " + strbasePath + "/src/test/resources/feature/");
        writeToFile(strbasePath +"/src/test/java/com/qaaipoc/pageObject/", JIRA_ID + "_Page.java", pomFile);
    }


    public static void uploadFileToGitHub(String filePath, String content, String commitMessage) throws IOException {
        String base64Content = Base64.getEncoder().encodeToString(content.getBytes());
        String jsonPayload = String.format(
                "{ \"message\": \"%s\", \"content\": \"%s\" }",
                commitMessage, base64Content
        );

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(String.format("%s/repos/%s/%s/contents/%s", GITHUB_API_URL, REPO_OWNER, REPO_NAME, filePath))
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .header("Accept", "application/vnd.github.v3+json")
                .put(RequestBody.create(jsonPayload, MediaType.parse("application/json")))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                System.out.println("File uploaded successfully!");
                System.out.println("Response: " + response.body().string());
            } else {
                System.err.println("Failed to upload file. HTTP Code: " + response.code());
                System.err.println("Error: " + response.body().string());
            }
        }

    }

}

