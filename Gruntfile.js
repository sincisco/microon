var path=require('path');
module.exports = function(grunt) {

    // Project configuration.
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        copy: {
            jquery: {   expand: true,
                flatten: true,
                cwd: 'bower_components',
                src: ['jquery/dist/jquery.js'],
                dest: 'src/main/webapp/js-lib/jquery',
                filter: 'isFile'},
                
                bootstrap: {   expand: true,
                    flatten: false,
                    cwd: 'bower_components/bootstrap/dist',
                    src: ['js/bootstrap.js',
                          'css/bootstrap.css',
                          'fonts/glyphicons-halflings-regular.eot',
                          'fonts/glyphicons-halflings-regular.svg',
                          'fonts/glyphicons-halflings-regular.ttf',
                          'fonts/glyphicons-halflings-regular.woff',
                          'fonts/glyphicons-halflings-regular.woff2'],
                    dest: 'src/main/webapp/js-lib/bootstrap',
                    filter: 'isFile'},
                
                datatables: {   expand: true,
                    flatten: false,
                    cwd: 'bower_components/datatables/media',
                    src: ['js/jquery.dataTables.js',
                          'css/jquery.dataTables.css',
                          'images/sort_asc_disabled.png',
                          'images/sort_asc.png',
                          'images/sort_both.png',
                          'images/sort_desc_disabled.png',
                          'images/sort_desc.png'],
                    dest: 'src/main/webapp/js-lib/datatables',
                    filter: 'isFile'},
                    
                easyui: {   expand: true,
                    flatten: false,
                    cwd: 'bower_components/jquery-easyui-bower',
                    src: ['jquery.easyui.min.js',
                          'themes/**',
                          'locale/*'],
                    dest: 'src/main/webapp/js-lib/easyui',
                    filter: 'isFile'}

        },
        clean: {
            preBuild: {
                src: ["src/main/webapp/js-lib"]
            }
        }
    });


    grunt.event.on('watch', function(action, filepath, target) {
        if(target==='html') {
            grunt.log.writeln(filepath.substring(4,filepath.length));
            grunt.config('copy.html.src', filepath.substring(4,filepath.length));
        }

        if(target==='css') {
            grunt.log.writeln(filepath.substring("app/styles/".length,filepath.length));
            grunt.config('copy.css.src', filepath.substring("app/styles/".length,filepath.length));
        }

        grunt.log.writeln(target + ': ' + filepath + ' has ' + action);
    });


    // 加载包含 "copy" 任务的插件。
    grunt.loadNpmTasks('grunt-contrib-copy');
    // 加载包含 "concat" 任务的插件。
    grunt.loadNpmTasks('grunt-contrib-concat');
    // 加载包含 "clean" 任务的插件。
    grunt.loadNpmTasks('grunt-contrib-clean');
    // 加载包含 "watch" 任务的插件。
    grunt.loadNpmTasks('grunt-contrib-watch');


    // 默认被执行的任务列表。
    grunt.registerTask('default', []);
    grunt.registerTask('all', ['clean','copy']);



};