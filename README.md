# SpringBoot

# MVC pattern
* Model : Send data shown in a final web page to `View`
* View : Create a final view web page
* Controller : Receive a request from a client (Link method using annotation `@GetMapping`)  

# View template & layout
* layout : define *header* and *footer* seperately (`layouts/header.mustache`, `layouts/footer.mustache`)
* Fetche layouts using `{{>layouts/header}}` and `{{>layouts/footer}}` (refere `viewTemp.mustache`)
* Link view(`viewTemp.mustache`) to web page(`/viewtemp`) using annotation `@GetMapping("/viewtemp")`

# Form data transmission
* Model : Send data shown in a final web page to `View`
* Model : Send data shown in a final web page to `View`
