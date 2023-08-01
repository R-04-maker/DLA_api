package astratech.dla_api.service;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class FcmNotificationService {
    private final String fcmServerKey = "AAAAcZhYIVU:APA91bFihTdU1QFQH4shxnr13IHNR2Ue5VVhW85VQCkIZgBeYcMjkUcEYUOByTYP4p1COM3UipwA7YcScJt_VPYmz98PmmOsz5VXGJeyzy1w4hgF8emnq5Pepa-9g4MRX2Z6kg1qVng-";
    private final String fcmEndpoint = "https://fcm.googleapis.com/fcm/send";

    public ResponseEntity<String> sendNotification(String token, String title, String value) {
        try {
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
