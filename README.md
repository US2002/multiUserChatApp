# MultiUser Chat App
The MultiUser Chat App is a real-time messaging application that allows users to register using a SQL server, log in with secure password protection, and engage in multiple simultaneous chat sessions with other clients.

## Features
1. **User Registration**: Users can register with a unique username and a securely encrypted password, stored in a SQL database.
2. **Secure Login**: Users can log in using their registered credentials, with password verification from the SQL server.
3. **MultiUser Chat**: Users can engage in real-time chat sessions with multiple clients simultaneously.
4. **Password Protection**: Passwords are securely protected using encryption techniques for enhanced security.
5. **Intuitive Interface**: The app provides a user-friendly interface for seamless chatting experience.
6. **Server-Client Communication**: The app uses server-client architecture for efficient and reliable message exchange.

## Technologies Used
- Java Swing Framework
- SQL Server
- Encryption Libraries (for password protection)

## ScreenShots
![App Screenshot](https://github.com/US2002/multiUserChatApp/blob/main/Assets/MultiUserChatAppPhoto.png)

## Installation
To install and run the Recipe Generator App on your device, follow these steps:
1. Clone this repository to your local machine using ***git clone https://github.com/US2002/multiUserChatApp.git***.
2. Navigate to the project directory.
3. Ensure that you have Java Development Kit (JDK) installed on your computer & SQL Server configured and running.. If not, refer to the official Java documentation for installation instructions.
4. Compile the Java source files:
```bash
  javac *.java
```
5. Run the server on one terminal:
```bash
  java Server
```
6. Run multiple client instances on separate terminals:
```bash
  java Client
```


## Usage/Examples
- Launch the client application.
- Register a new account using a unique username and a secure password.
- Log in with your registered credentials.
- Start chatting with other clients who are online.

## Contributions
We welcome contributions from the open-source community to enhance the functionality and features of the Multi User Chat App. If you would like to contribute, please follow these steps:
1. Fork this repository.
2. Create a new branch with a descriptive name (git checkout -b my-new-feature).
3. Make the desired changes or additions.
4. Commit your changes (git commit -am 'Add some feature').
5. Push the branch to your forked repository (git push origin my-new-feature).
6. Create a new Pull Request.

## Feedback and Support
We would love to hear your feedback and suggestions for improving the Multi User Chat App. If you encounter any issues or have any questions, please create a new issue in the issue tracker.

## License
The Multi User Chat App is open source and released under the MIT License. Feel free to modify and distribute the app as per the license terms.
