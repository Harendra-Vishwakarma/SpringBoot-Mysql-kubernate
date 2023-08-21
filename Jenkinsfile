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
               bat "docker build -t springapp ."
            }
        }
         stage("Deploy"){
            steps{
               bat "docker-compose down && docker-compose up -d"
            }
        }
    }
}
