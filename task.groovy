pipeline {
    agent any
    environment {
        PATH = "home/ubuntu/Downloads/META-INF:$PATH"
    }
    stages {
        stage('Git checkout stage')
        {
            steps {
                git credentialsId: 'git_credentials', url: 'https://github.com/valaxyTech/hello-world.git'
                 echo "pulled the code...."
            }
        }
        stage('Maven Built stage')
        {
            steps {
                sh "mvn clean install"
                
            }
        }
    }
}