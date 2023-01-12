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
                    script {
                    
                    sh '''#!/bin/bash
                    cd /
                     cd /var/lib/jenkins/workspace/devopstask/webapp/target/webapp.war
                    cd /
                    cp home/ubuntu/Downloads/apache-tomcat-9.0.70/webapps
                    echo " war filed copied "
                    
                    }
                }
            }
    }
}  
                