pipeline {
    agent any
    environment {
        PATH = "/usr/share/maven:$PATH"
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
                sh " cd hello-world/tree/master/webapp"
                sh "mvn clean install"

            }
                
            }
        }
       
    }
}