pipieline {
    agent any
    environment
    {
        USER_NAME ="Deepika"
    }
    stages{
        stage("Details"){
            steps{
                echo "${USER_NAME}"
                echo "employee id is 644 "
            }
        }
    }  
} 