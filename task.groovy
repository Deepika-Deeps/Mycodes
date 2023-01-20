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
                    sh 'sudo su jenkins'
                       sh 'sudo cp /var/lib/jenkins/workspace/devopstask/webapp/pom.xml /home/ubuntu/Downloads/apache-tomcat-9.0.70/webapps'

                }
            }
            stage('restart tomcat stage')
            {
                steps 
                {
                 sh '/opt/apache-tomcat9/bin/startup.sh /usr/bin/tomcatup'

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
                