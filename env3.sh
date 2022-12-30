pipeline {
    agent any 
    parameters {
  booleanParam description: 'is this is authorized employee', name: 'authorized'
  choice choices: ['name ', 'id ', 'organisation'], description: 'select the details', name: 'details'
  credentials credentialType: 'com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl', defaultValue: 'd5b846c5-ab03-4b14-81d7-554db2a8ee96', description: 'give the user name and password ', name: 'enter the values', required: false
  string defaultValue: 'deepika', description: 'enter your name', name: 'name', trim: true
  password defaultValue: 'deepika', description: 'enter the password', name: 'password'
  run description: 'project is running', filter: 'ALL', name: 'run the project', projectName: 'env3 script'
}
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