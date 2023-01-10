pipeline {
    agent any
    environment {
        PATH = "/usr/share/maven:$PATH"
    }
    tools {
        maven 'mavenHome'
        jdk 'JavaHome'
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
                bat ' mvn -f webapp/pom.xml clean install'
                post {
                success {
                    echo 'Now Archiving'
                }
            }
                
            }
        }
       
    }
}