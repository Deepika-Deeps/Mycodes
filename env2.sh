pipeline {
    agent any 
    environment {
        USER_NAME = 'Deepika'
    }
    stages {
        stage('Details') {
            steps {
                sh "echo $USER_NAME"
                sh "env |sort "
            }
        }
    }
}