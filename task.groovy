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
            
                sh  ' mvn  clean install'

            }
                
            }
            stage('copy stage')
            {
                steps
                {
                    def source="var/lib/jenkins/workspace/devopstask/webapp/target/webapp.war"
                    def destination="/home/ubuntu/Downloads/apache-tomcat-9.0.70/webapps"

                    sh 'scp -r ${var/lib/jenkins/workspace/devopstask/webapp/target/webapp.war} ${/home/ubuntu/Downloads/apache-tomcat-9.0.70/webapps}'

                }
            }
            stage('restart tomcat stage')
            {
                steps 
                {
                    sh ' sudo servive restart '
                }
            }
    }
}  
                