pipieline {
    agent any
    {
    environment
    {
        USER_NAME ="Deepika"
    }
    }
    stages{
        stage("Details") {
            steps{
                echo "employee Name is ${USER_NAME}"
                echo "employee id "
            }
        }
    }
}   