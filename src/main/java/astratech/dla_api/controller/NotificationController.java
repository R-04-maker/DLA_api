package astratech.dla_api.controller;

import astratech.dla_api.result.result;
import astratech.dla_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;


@RestController
public class NotificationController {

    @Autowired
    UserService userService;

    @PostMapping("/saveToken")
    public Object saveToken(HttpServletResponse response, @RequestParam("token") String token, @RequestParam("email") String email){
        try{
            userService.saveToken(token, email);
            return new result(200, "Success");
        }catch (Exception e){
            return new result(500,"Failed");
        }
    }

    @PostMapping("/deleteToken")
    public Object deleteToken(HttpServletResponse response, @RequestParam("email") String email){
        try{
            userService.deleteToken(email);
            return new result(200, "Success");
        }catch (Exception e){
            return new result(500,"Failed");
        }
    }

    @PostMapping("/sendNotification")
    public ResponseEntity<String> sendNotification(@RequestParam("token") String token) {
        try {
            // The sendNotification function code
            String fcmServerKey = "AAAA9yYRluo:APA91bFuMa8qPlEiGhti4Osh-1X-KtWUUV0EID-umy5jyWIuqBYoVkUPkAOD9e1rExRVrDYxVDMlePWDr0j7MSxPvtIcZT94BIdgBPwcwiX-6xto2jKJxe5lHFXDZI_3G27hnuxsvNKH";
            String fcmEndpoint = "https://fcm.googleapis.com/fcm/send";
            String title = "OKE";
            String value = "aa";

            String message = "{"
                    + "\"to\": \""+token+"\","
                    + "\"notification\": {"
                    + "\"title\": \""+title+"\","
                    + "\"body\": \""+value+"\""
                    + "},"
                    + "\"data\": {"
                    + "\"key1\": \"value1\","
                    + "\"key2\": \"value2\""
                    + "}"
                    + "}";

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "key=" + fcmServerKey);
            HttpEntity<String> requestEntity = new HttpEntity<>(message, headers);

            ResponseEntity<String> responseEntity = restTemplate.exchange(fcmEndpoint, HttpMethod.POST, requestEntity, String.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.ok("Notification sent successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send notification.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send notification.");
        }
    }
}
