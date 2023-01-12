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
                   
                    bat '''copy c:\\var\\lib\\jenkins\\workspace\\devopstask\\webapp\\target\\*.war F:\\Downloads\\apache-tomcat-9.0.70\\webapps\\'''
                    echo " war filed copied " 
                    
                    }
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
                