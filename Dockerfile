FROM daocloud.io/library/ubuntu:18.10
LABEL Name=cordova-docs Version=1.0.1

WORKDIR /root/app
ADD . /root/app

RUN sed -i "s|http://archive.ubuntu.com|http://mirrors.aliyun.com|g" /etc/apt/sources.list && rm -Rf /var/lib/apt/lists/* && apt-get -y update

RUN apt-get install -y ruby-full

RUN apt-get install -y nodejs
RUN apt-get install -y npm
RUN npm config set registry http://registry.npm.taobao.org

RUN apt-get install -y python2.7

RUN gem sources --add https://gems.ruby-china.com/ --remove https://rubygems.org/
RUN gem install bundler

RUN bundle install --path ./ruby_modules

RUN npm install

CMD ["/bin/bash"]