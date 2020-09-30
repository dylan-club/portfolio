/**
 * load the project details(name, image, description, summary, link...)
 * @returns {string}
 */
function loadProjectDetail(projects){
    var content = "";
    for (var i = 0; i < projects.length; i++) {
        if (projects[i].address.split("?")[1] === location.search.replace("?","")){
            content += '<p hidden id="pId">'+projects[i].id+'</p>\n'+
                '<h1 id="pName" class="text-center">'+projects[i].name+'</h1>\n' +
                '        <div id="page-content">\n' +
                '            <img src="'+randomImageURI()+'" alt="project description" class="img-thumbnail">\n' +
                '            <h2>Project Description</h2>\n' +
                '            <p id="pDescription" class="text-info text-content" >'+projects[i].description+'</p>\n' +
                '            <h2>Project Summary</h2>\n' +
                '            <p id="pSummary" class="text-info text-content" >'+projects[i].summary+'</p>' +
                '            <h2>Project Link</h2>\n' +
                '            <a id="pLink" class="btn btn-default" href="'+projects[i].linkDetail+'" role="button" target="_blank">'+projects[i].linkInfo+'</a>\n' +
                '        </div>';
            break;
        }

    }

    return content;
}


/**
 * load the project's brief description(name, description, image)
 * @returns {string}
 */
function loadProjectBrief(projects) {
    var project = "";
    for (var i = 0; i < projects.length; i++) {
        project += '                        <div class="row">\n' +
            '                            <div class="col-md-12">\n' +
            '                                <div class="thumbnail">\n' +
            '                                    <img class="projectImage" src="'+randomImageURI()+'" alt="write blog">\n' +
            '                                    <div class="caption">\n' +
            '                                        <h3>'+projects[i].name+'</h3>\n' +
            '                                        <p class="text-info">'+projects[i].description+'</p>\n' +
            '                                        <p class="text-center"><a href="'+projects[i].address+'" class="btn btn-primary" role="button">View More</a></p>\n' +
            '                                    </div>\n' +
            '                                </div>\n' +
            '                            </div>\n' +
            '                        </div>';
    }

    return project;
}

/**
 * load projects' name into navigation bar
 * @returns {string}
 */
function loadProjectNav(projects) {
    var list = "";
    for (var i = 0; i < projects.length; i++) {
        var href = projects[i].address;
        list += '<li><a href="'+href+'">'+projects[i].name+'</a></li>'
    }
    return list;
}

