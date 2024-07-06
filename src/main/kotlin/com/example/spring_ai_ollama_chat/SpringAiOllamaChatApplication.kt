package com.example.spring_ai_ollama_chat

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.chat.model.ChatModel
import org.springframework.ai.chat.prompt.PromptTemplate
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication
class SpringAiOllamaChatApplication {
    @Bean
    fun chatClient(chatModel: ChatModel): ChatClient {
        return ChatClient
            .builder(chatModel)
            .build()
    }
}

@Controller
@RequestMapping("/ollama")
class OllamaChatController(
    private val chatClient: ChatClient,
) {
    @GetMapping
    @ResponseBody
    fun home(@RequestParam(value = "name", defaultValue = "홍길동") name: String): String {
        val prompt = PromptTemplate("안녕? 나의 이름은 {name} 이야")
            .create(
                mapOf("name" to name)
            )
        return chatClient.prompt(prompt)
            .call()
            .chatResponse()
            .result
            .output
            .content
    }
}

fun main(args: Array<String>) {
    runApplication<SpringAiOllamaChatApplication>(*args)
}
