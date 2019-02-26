pipeline {

    agent any
    stages {
        stage('SCM Checkout') {

            steps {

                echo 'Checkout'
                git 'https://github.com/Nagamathan/WebApp-SOBI.git'

            }

        }
        stage('Build') {

            steps {

                echo 'Building '
                bat label: '', script: 'mvn clean package'

            }
            

        }
		stage('Build Email Notification'){
		
			steps {
				   mail bcc: '', body: '''Hi 
				   WebApp-SOBI Build is completed.
					Thanks
				Sobiadmin''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job - Build Successful', to: 'sobihackathon@gmail.com'
            }
			
        }
		stage('Test') {

            steps {

                echo 'Testing'
				bat label: '', script: 'mvn verify'

            }

        }
		stage('Test Email Notification'){
		
			steps {
				  mail bcc: '', body: '''Hi 
				   WebApp-SOBI Test execution is completed.
					Thanks
				Sobiadmin''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job - Testing Execution Successful', to: 'sobihackathon@gmail.com'
            }
			
        }		
		stage('Production Approval') {

			steps {

				input "Proceed with Deploying the code to Target Environment. Do you approve?"

			}

		}
        stage('Deploy') {

            steps {

                echo 'Deployment Started'
				echo 'Deploying the War files to tomcat server http://localhost:9898/'
                bat label: '', script: '''echo %CD%
				echo %date%
                copy target\\*.war D:\\Users\\Umakiran\\Desktop\\Development\\webapps\\'''
                  }

        }
		stage('Deploy Email Notification'){
		
			steps {
				  mail bcc: '', body: '''Hi User,
				  
				   WebApp-SOBI Deployment is Successful.
				   
					Thanks
				Sobiadmin''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job - Deployment Successful', to: 'sobihackathon@gmail.com'
            }
			
        }		

    }

}
