pipeline {
    agent any
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
                echo " Maven is installed...."
            }
        }
    }
}