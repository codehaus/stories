dataSource {
	pooled = false
    dbCreate = "create-drop" // one of 'create', 'create-drop','update'
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
			dbCreate = "none" // one of 'create', 'create-drop','update'
			url = "jdbc:postgresql://localhost:5432/stories_dev"
		}
	}
	test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:hsqldb:mem:testDb"
		}
	}
	production {
		dataSource {
			dbCreate = "update"
			url = "jdbc:hsqldb:file:prodDb;shutdown=true"
		}
	}
}