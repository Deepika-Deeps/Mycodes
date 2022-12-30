pipeline {
    agent any 
    enivorment {
        USER_NAME = 'Deepika'
    }
    stages {
        stages('Details') {
            steps {
                sh "echo $USER_NAME"
                sh "env |sort "
            }
        }
    }
}