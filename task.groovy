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
            script {
                sh  ' mvn  clean install'
            }

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
                    script {
                    sh 'sudo su jenkins'
                       sh 'sudo cp /var/lib/jenkins/workspace/devopstask/webapp/pom.xml /opt/tomcat/webapps'
                    }

                }
            }
            stage('restart tomcat stage')
            {
                steps 
                {
                    script{
                 sh 'sudo /opt/tomcat9/bin/./startup.sh'
                    }

                }
            }
            stage('cleanup stage')
            {
                steps{
                    script{
                        cleanWs()
                    }
                }
            }
    }
}  
                
