pipeline{
    agent any
    tools{
        maven "maven"
    }
    
    stages{
        stage("code"){
            steps{
                git url:'https://github.com/Harendra-Vishwakarma/Spring-Boot-With-Docker.git', branch:"main"
            }
        }
         stage("Build"){
            steps{
              bat "mvn -Dmaven.test.skip=true clean package"
               bat "docker build -t springboot-mysql-k8s:1.0 ."
            }
        }
         stage("docker image bused on docker hub"){
            steps{
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'dockerhubPass', usernameVariable: 'dockerhubUser')]) {
               bat "docker login -u ${env.dockerhubUser} -p ${env.dockerhubPass}"
               bat "docker tag springapp ${env.dockerhubUser}/springboot-mysql-k8s:1.0"
               bat "docker push ${env.dockerhubUser}/springapp:v1 "
              }
            }
        }
         stage("deplo on kubernets (minikube)"){
            steps{
              bat "kubectl apply -f app-deployment.yaml
            }
        }
    }
}
