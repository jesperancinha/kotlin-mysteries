FROM postgres:15

COPY . /docker-entrypoint-initdb.d

ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=admin
ENV POSTGRES_MULTIPLE_DATABASES=carparts,carparts_data_structures

EXPOSE 5432
