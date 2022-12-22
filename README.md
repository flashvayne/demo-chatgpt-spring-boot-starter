# demo-chatgpt-spring-boot-starter

this is a demo project for [chatgpt-spring-boot-starter]https://github.com/flashvayne/chatgpt-spring-boot-starter

## Usage
1.clone the code.
2.set your chatgpt.api-key in "application.yml".
3.run it, and then you can chat with chatgpt by this api.

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

# Author Info
Email: flashvayne@gmail.com

Blog: https://vayne.cc