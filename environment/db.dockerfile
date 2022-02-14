FROM postgres:12.6

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres
ENV POSTGRES_DB=postgres

RUN apt update
RUN apt-get install -y postgresql-12-tds-fdw