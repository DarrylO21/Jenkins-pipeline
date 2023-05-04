pipeline{
    agent any
    environment {
        BUILD_AUTOMATION_TOOL = "Gradle"
        TEST_AUTOMATION_TOOL = "Selenium"
        CODE_ANALYSIS_TOOL = "Klocwork"
        SECURITY_SCAN_TOOL = "Coverity"
        STAGING_TOOL = "DigitalOcean"
        DEPLOYMENT_TOOL = "Ansible"
    }
    stages{
        stage('Build'){
            steps{
                echo "Compiling and packaging code in $BUILD_AUTOMATION_TOOL"
            }
        }
        stage('Unit and Integration Tests'){
            steps{
                echo "Running tests in $TEST_AUTOMATION_TOOL"

                echo "Running unit tests to ensure the code is functioning as expected"

                echo "Running integration tests to ensure different components of the application are working together as expected"
            }
            post{
                always{
                    emailext attachLog: true,
                    to: "darryldeal21@gmail.com",
                    subject: "Unit and Integration Tests Status Email",
                    body: "Unit and Integration Tests Status: ${currentBuild.currentResult}\nStage logs attached below."
                }
            }
        }
        stage('Code Analysis'){
            steps{
                echo "Analysing code to ensure it meets industry standards in $CODE_ANALYSIS_TOOL"
            }
        }
        stage('Security Scan'){
            steps{
                echo "Performing security scan on the code in $SECURITY_SCAN_TOOL to identify any vulnerabilities"
            }
        }
        stage('Deploy to Staging'){
            steps{
                echo "Deploying application to a staging server on $STAGING_TOOL"
            }
        }
        stage('Integration Tests on Staging'){
            steps{
                echo "Running integration tests on the staging environment to ensure the application functions as expected in a production-like environment"
            }
        }
        stage('Deploy to Production'){
            steps{
                echo "Deploying application to a production server on $DEPLOYMENT_TOOL"
            }
        }
    }
}