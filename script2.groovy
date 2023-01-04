pipeline
{
    agent any

    environment{
        EMPLOYEE_NAME = 'deepika'
        EMPLOYEE_ID = '644'

    }
    stages {
        stage{"details"} {
            steps {
                echo " the details of employee is $EMPLOYEE_NAME, $EMPLOYEE_ID"
            }
         }
    }
}