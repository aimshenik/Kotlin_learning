package selfeducation.resttemplate

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate


fun main() {
    val restTemplate = RestTemplate() //spring-boot-starter-web
    val url = "https://yandex.ru/"
    val response: ResponseEntity<String> = restTemplate.getForEntity(url, String::class.java)
    println(response)
    assert(response.getStatusCode().equals(HttpStatus.OK))
}