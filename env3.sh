pipeline {
    agent any 
    environment {
        COMPANY_NAME = 'infinite'
    }
    stages{
        stage('Employee1') {
            environment {
                USER_NAME = 'deepika'
            }
            steps {
                sh "echo organisation working in  $COMPANY_NAME"
                sh "echo employee name $USER_NAME"
            }
        }
        stage('employee 2'){
            steps {
                sh "echo $COMPANY_NAME"
        }
        }
        stage('employee 3'){
         steps {   sh "echo employee id 644"
        }
        }
    }
}