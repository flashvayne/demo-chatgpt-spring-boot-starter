# demo-chatgpt-spring-boot-starter

This is a demo project for [chatgpt-spring-boot-starter]https://github.com/flashvayne/chatgpt-spring-boot-starter

## Demo online experience
https://vayne.cc/chat/

*My account's request times quota is exceeded, so my demo does not work now.
You can use your own account api-key to let your demo work.  

<i>**The web page is written by ChatGPT for me, which is very simple. If anyone is good at the front end, you can create a pull request to help optimize it. Thank you.
File Path: src/main/resources/static/index.html</i>
## Usage
## 1.clone the code.  
## 2.set your chatgpt.api-key in "application.yml".  
## 3.run it, and then you can chat with chatgpt by this api.  
### 3.1 Single message  
+ request
```shell
curl --location --request GET '127.0.0.1:8080/send?message=how are you'
```

+ response
```json
{
  "code": 200,
  "message": "success",
  "data": "\n\nI'm doing well, thank you. How about you?"
}
```
### 3.2 Multi message
+ request
```shell
curl --location 'http://127.0.0.1:8080/multi/send' \
--header 'Content-Type: application/json' \
--data '[
    {
        "role": "system",
        "content": "You are a helpful assistant."
    },
    {
        "role": "user",
        "content": "Who won the world series in 2020?"
    },
    {
        "role": "assistant",
        "content": "The Los Angeles Dodgers won the World Series in 2020."
    },
    {
        "role": "user",
        "content": "Where was it played?"
    }
]'
```

+ response
```json
{
  "code": 200,
  "message": "success",
  "data": "The 2020 World Series was played at Globe Life Field, in Arlington, Texas."
}
```

# Author Info
Email: flashvayne@gmail.com

Blog: https://vayne.cc
