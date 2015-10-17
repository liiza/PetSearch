# PetSearch
Index data from website for animal shelters and build search engine with Elasticsearch.
Java Spring Boot + AngularJS

Building on open api:
https://www.petfinder.com/developers/api-docs

The petfinder api provides information about adoptable animals in USA.
My idea was to create a full text search over data provided by api.
The petfinder website provides ways to filter data, but no full text search.
I believe that full text search appeals more users and helps users to find an adoptable pet faster.
My search also search over description field, which helps to find a pet based on animals character.


The UI is really simple. User can write search terms to search field and sees the results instantly.
By clicking the results user can view the animal information in the petfinder web site and possibly adopt the animal.

The service is running in
https://pacific-temple-7389.herokuapp.com/



![screenshot] (././screenshots/search.png)
