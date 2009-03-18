dataSource {
	pooled = false
    url = "jdbc:postgresql://localhost:5432/stories"
    driverClassName = "org.postgresql.Driver"
    dialect = org.hibernate.dialect.PostgreSQLDialect
    username = "grails"
    password = "java4ever"
}
hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='com.opensymphony.oscache.hibernate.OSCacheProvider'
}
// environment specific settings
environments {
	development {
		dataSource {
			url = "jdbc:postgresql://localhost:5432/stories_dev"
		}
	}
	test {
		dataSource {
			url = "jdbc:hsqldb:mem:testDb"
		}
	}
	production {
		dataSource {
			url = "jdbc:hsqldb:file:prodDb;shutdown=true"
		}
	}
}