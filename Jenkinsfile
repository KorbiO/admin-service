pipeline {
	agent any
	tools {
    maven 'maven-3'
    jdk 'java'
  }
  
	stages {
		stage('SCM Checkout'){
			steps{
        	git credentialsId: 'gitPwd', url: 'https://github.com/KorbiO/admin-service'
        		}
    }
		stage('Compile') {
			steps {
			withMaven(maven : 'maven-3'){
				
				bat './mvnw clean compile'
				
				
			}	
				  }
		}
		stage('Package') {
			steps {
			withMaven(maven : 'maven-3'){
				
				
				bat './mvnw package -DskipTests'
				
			}	
				  }
		}
		stage('Build Docker Image'){
			steps{
        		bat 'docker build -t omarkorbi/admin-service:latest .'
        		}
    }
    stage('Push Docker Image'){
     	steps{
	        bat 'docker login -u omarkorbi -p gotktpas123'
	  		bat 'docker tag omarkorbi/admin-service:latest omarkorbi/admin-service '
	  		bat 'docker push omarkorbi/admin-service'
	  		}
    }
     stage('Run Kubernetes'){
    	steps{
    	
   	   		bat 'kubectl --kubeconfig ./config apply -f deployment.yaml'
   	   		}
    }
     
    
		
	}
}