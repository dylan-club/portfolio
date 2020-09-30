function randomImageURI() {

    var imageName = Math.ceil(Math.random()*3);
    var imgURI = "resources/images/" + imageName + ".jpg";

    return imgURI;
}