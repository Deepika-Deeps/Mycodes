pipeline {
    agent any
    tools{
        maven'Maven_local'
    }
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
            
                sh  ' mvn  clean install'

            }
            post{
                success{
                    echo"Archiving the Artifacts"
                    archiveArtifacts artifacts:'**/target/*.war'
                }
            }
                
            }
            stage('copy stage')
            {
                steps
                {
                       deploy adapters: [tomcat9(credentialsId: '1de694ae-9fab-491c-91ca-282b8ad26a0e', path: '', url: 'http://localhost:8081/')], contextPath: null, war: '**/*.war'

                }
            }
            stage('restart tomcat stage')
            {
                steps 
                {
                    sh ' ./startup.sh '
                }
            }
    }
}  
                