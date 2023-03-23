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
## 3.run it, and then you can try these api.  
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

### 3.3 Image generation
+ request
```shell
curl --location 'http://127.0.0.1:8080/image?prompt=A%20cute%20baby%20sea%20otter'
```

+ response
```json
{
  "code": 200,
  "message": "success",
  "data": "https://oaidalleapiprodscus.blob.core.windows.net/private/org-Xvt3LZrBsj5vD21Ro4B0xHbU/user-d73MPClst7tMOylhDkwKPRWc/img-5OY52AjLbGoJrmeofZ5wcxuK.png?st=2023-03-23T06%3A35%3A51Z&se=2023-03-23T08%3A35%3A51Z&sp=r&sv=2021-08-06&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2023-03-23T06%3A13%3A41Z&ske=2023-03-24T06%3A13%3A41Z&sks=b&skv=2021-08-06&sig=P3kcZIXq9y0PB5PaFxv4Jc91n0Zf2VQngYFAbY%2BLVqU%3D"
}
```

+ request
```shell
curl --location 'http://127.0.0.1:8080/images?prompt=A%20cute%20baby%20sea%20otter&n=2&size=1&format=url'
```

+ response
```json
{
  "code": 200,
  "message": "success",
  "data": [
    "https://oaidalleapiprodscus.blob.core.windows.net/private/org-Xvt3LZrBsj5vD21Ro4B0xHbU/user-d73MPClst7tMOylhDkwKPRWc/img-WicmIRunQ2J5lpcX3T9VYmYY.png?st=2023-03-23T06%3A48%3A07Z&se=2023-03-23T08%3A48%3A07Z&sp=r&sv=2021-08-06&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2023-03-23T05%3A55%3A20Z&ske=2023-03-24T05%3A55%3A20Z&sks=b&skv=2021-08-06&sig=1MGQIv0IQkDZ2xHdLBdxzoWNC3QQxkG4T3DNpxQ/ZwA%3D",
    "https://oaidalleapiprodscus.blob.core.windows.net/private/org-Xvt3LZrBsj5vD21Ro4B0xHbU/user-d73MPClst7tMOylhDkwKPRWc/img-6KURQa0u4JxgC0CNwFU27EwT.png?st=2023-03-23T06%3A48%3A07Z&se=2023-03-23T08%3A48%3A07Z&sp=r&sv=2021-08-06&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2023-03-23T05%3A55%3A20Z&ske=2023-03-24T05%3A55%3A20Z&sks=b&skv=2021-08-06&sig=vpKWaxBN6TnHZG9uqcQslq1ssIY417qxCd2iyXuZRE0%3D"
  ]
}
```

# Author Info
Email: flashvayne@gmail.com

Blog: https://vayne.cc
