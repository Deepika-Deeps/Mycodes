pipieline {
    agent any
    {
    environment
    {
        USER_NAME ="Deepika"
        USER_ID = 644
    }
    }
    stages{
        stage("Details") {
            steps{
                echo "employee Name is ${USER_NAME}"
                echo "employee id is ${USER_ID}"
            }
        }
    }
}   