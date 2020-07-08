let course_Id = 0;
let work_Id = 0;
let answer = [];

let topicId = 1;
let optionTitle = 66;
let optionId = 2;
let optionArray = new Array();
function initOption(){
    optionTitle = 66;
    optionId = 2;
}
/**
 * 增加选项
 * */
$(document).on("click","[name = 'addOption']",function () {
    let group = $(this).prev();
    let label = document.createElement('label');
    label.innerText = String.fromCharCode(optionTitle)+". ";
    let input = document.createElement('input');
    input.id = 'option_' + topicId + '_' + optionId;
    input.name = 'option';
    input.className = 'form-control col-2';
    group.append(label);
    group.append(input);
    optionArray[topicId-1] = optionId;
    optionTitle++;
    optionId++;
});
/**
 * 删除选项
 * */
$(document).on("click","[name = deleteOption]",function () {
    let group = $(this).prev().prev();
    group.children("input:last-child").remove();
    group.children("label:last-child").remove();
    optionTitle--;
    optionId--;
    optionArray[topicId-1] = optionId-1;

});
/**
 * 增加题目
 * */
$(document).on("click","[name = addTopic]",function () {
    topicId++;
    initOption();
    let card = document.createElement('div');
    card.id = 'topic_group_'+topicId;
    card.className = "card";
    let body = document.createElement('div');
    body.className = "card-body";
    let group1 = document.createElement('div');
    group1.className = "form-group";
    let label1 = document.createElement('label');
    label1.innerText = "题目：";
    let input1 = document.createElement('input');
    input1.type = "text";
    input1.id = "topic_"+topicId;
    input1.name = "topic";
    input1.className = "form-control";
    group1.append(label1);
    group1.append(input1);
    body.append(group1);
    let group2 = document.createElement('div');
    group1.className = "form-group";
    let label2 = document.createElement('label');
    label2.innerText = "答案：";
    let input2 = document.createElement('input');
    input2.type = "text";
    input2.id = "answer_"+topicId;
    input2.name = "answer";
    input2.className = "form-control";
    group2.append(label2);
    group2.append(input2);
    body.append(group2);
    let br = document.createElement('br')
    body.append(br);
    let group3 = document.createElement('div');
    group3.className = "form-group form-inline";
    let label3 = document.createElement('label');
    label3.innerText = String.fromCharCode(65) + ".";
    let input3 = document.createElement('input');
    input3.className = "form-control col-2"
    input3.type = "text";
    input3.id = "option_"+topicId+"_1";
    input3.name = "option";
    group3.append(label3);
    group3.append(input3);
    body.append(group3);
    let button1 = document.createElement('button');
    button1.type = "button";
    button1.className = "btn btn-secondary";
    button1.name = "addOption";
    button1.innerText = "添加选项";
    let button2 = document.createElement('button');
    button2.type = "button";
    button2.className = "btn btn-secondary";
    button2.name = "deleteOption";
    button2.innerText = "删除选项";
    body.append(button1);
    body.append(" ")
    body.append(button2);
    card.append(body);
    $(this).before(card);
});
/**
 * 删除题目
 * */
$(document).on("click","[name = 'deleteTopic']",function () {
    let group = $(this).prev().prev();
    group.remove();
    topicId--;
    initOption();
});
/**
 * 提交试卷
 * */
$(document).on("click","#submit",function () {
    let object = {};
    object.title = $("#title").val();
    object.begin = $("#begin").val();
    object.end = $("#end").val();
    object.limited = $("#limited").val();
    let list = new Array();
    for (let i = 0 ; i < topicId;i++){
        list[i] = new Array();
        list[i][0] = $("#topic_"+(i+1)).val();
        list[i][1] = $("#answer_"+(i+1)).val();
        let ot = 65;
        for (let j = 0;j < optionArray[i];j++){
            let index = j+1;
            let beginNode = j+2;
            let option = {}
            option.top = String.fromCharCode(ot);
            option.content = $("#option_"+(i+1)+"_"+index).val();
            list[i][beginNode] = option;
            ot++;
        }
    }
    object.topic = list;
    let jsonData = JSON.stringify(object);
    $.ajax({
        url:"/createWork/submit",
        type:'POST',
        dataType:"json",
        data:
            {"jsonData": jsonData},
        success:function (result) {
            window.location.href('/workList');
        }});
});
function getWork() {
    $.ajax({
        url: "/doWork/get",
        data: {"work_Id":work_Id},
        type:'POST',
        dataType: "json",
        success:function (result) {

        }
    })
}
function createTopicList(result){
    let this_data = result.parseJSON();
    let work_data = this_data.work.parseJSON();
    let topics = JSON.parse(this_data.topics);
    let card = document.createElement('div');
    card.className = 'card';
    let card_body = document.createElement('div');
    card_body.className = 'card-body';
    let card_header = document.createElement('div');
    card_header.className = 'card-header';
    let h3 = document.createElement('h3')
    h3.className = 'text-center';
    h3.innerText = work_data.name;
    card_header.appendChild(h3);
    let form = document.createElement('form');
    for (let i = 0 ; i < topics.length ; i++){
         let topic = topics[i].parseJSON();
         let options = topic.options.parseJSON();
         let cCard = document.createElement('div');
         cCard.className = 'card';
         let cCardHead = document.createElement('div');
         cCardHead.className = 'card-header';
         cCardHead.innerText = topic.topic_content;
         let cCardBody = document.createElement('div');
         cCardBody.className = 'card-body form-group form-inline';
         for (let j = 0 ; j < options.length ; j++){
             let title = document.createElement('label');
             title.innerText = options[j].option+".";
             let radio = document.createElement('input');
             radio.type = 'radio';
             radio.className = 'form-control';
             radio.value = options[j].option_content;
             cCardBody.appendChild(title);
             cCardBody.appendChild(radio);
         }
         cCard.appendChild(cCardHead);
         cCard.appendChild(cCardBody);
         form.appendChild(cCard);
    }
    let submit = document.createElement('button');
    submit.id = 'submit'
    submit.className = 'btn btn-secondary mx-auto';
    submit.innerText = '提交';
    form.appendChild(submit);
    card_body.appendChild(form);
    card.appendChild(card_header)
        .appendChild(card_body);
}

$(document).on("click","#submit",function () {

})
$(document).ready(function () {
   $(".area").mouseenter(function () {
       $(this).children('a').stop().css("display","none");
       $(this).children('div').stop().fadeIn();


   });
   $(".area").mouseleave(function () {

       $(this).children('div').stop().css("display","none");
       $(this).children('a').stop().fadeIn();
   })
});


$(document).ajaxStart(function () {
    let div = document.createElement('div');
    div.className = "flex-center loading";
    div.id = 'loading_body';
    let img = document.createElement('img');
    img.src = "lib/wait.png";
    img.id = 'loading_image';
    img.className = "align-items-center justify-content-center";
    div.appendChild(img);
    let img1 = document.createElement('img');
    img1.src = "lib/check.png";
    img1.id = "complete_image";
    img1.className = "align-items-center justify-content-center loading-complete";
    img1.style.display = 'none';
    div.appendChild(img1);
    let p = document.createElement('p');
    p.innerText = 'Loading...';
    p.className = 'text-center';
    div.appendChild(p);
    $("body").append(div);
    setInterval(function () {
        $("#loading_image").rotate({
            angle:0,
            animateTo:360,
            duration:1000
        });
    },1000);
});
$(document).ajaxStop(function () {
    $("#loading_image").stopRotate().animate({
        width:0,
        height:0
    },300).fadeOut()
        .find(".loading-complete").fadeIn().animate({
        width: 64,
        height: 64
    },200)
        .find("#loading_body").setTimeout(function () {
            $("#loading_body").remove();
    });
});