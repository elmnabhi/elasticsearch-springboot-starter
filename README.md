# ElsaticSearch RS2I Starter

To run ElasticSearch Starter, we should follow this steps

* Prerequisite-1: Install Java and set `JAVA_HOME` and PATH variables.
* Prerequisite-2: Install Maven.
* Prerequisite-3: Install Elasticsearch 2.4.0
Let us assume `ELASTICSEARCH_HOME = C:\elasticsearch-2.4.0`
* Prerequisite-4: Configure ElasticSearch Cluster
Open `${ELASTICSEARCH_HOME}\config\elasticsearch.yml` and add the following configuration
`cluster.name: rs2i-cluster`
* check http://localhost:9200 