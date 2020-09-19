
function  dell(){
    alert("asdasdas");

}


var vm = new Vue({
    el: '#app',
    data: {

        MenuBody: '这里是菜单的内容',
        obj:{},
        list:[
            {
                name:'asd',
                password:'asd',
                phone:'asd',

                username:'asd',

            },


        ]
    },
    methods:{
        show:function () {
            axios({
                url:"http://localhost:8182/mall/userTest/showUser",
                headers: {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'},
                method:'post',
                data:{age:30}
            }).then(
                function (res) {
                    this.obj=res;


                    alert(res)
                    alert(res.data);
                    alert(res.state);
                    alert(res.message);
                }

            ).catch(
                function (reason) {
                    alert("四百");
                }

            )

        }


    }

});