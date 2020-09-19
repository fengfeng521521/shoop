<template>
  <ul>
    <li>id: {{$route.params.id}}</li>
    <li>addr: {{detail.addr}}</li>
    <li>email: {{detail.email}}</li>
    <li>name: {{detail.name}}</li>
    <li>password: {{detail.password}}</li>
    <li>phone: {{detail.phone}}</li>
    <li>username: {{detail.username}}</li>

  </ul>
</template>

<script>
    import axios from 'axios'
  var messageDetails = [

  ]
  export default {
    data() {
      return {
        detail: {}
      }
    },
    mounted () {

        // 改变当前路由组件参数数据时, 不会重新创建组件对象, mounted不会重新执行
        const url = `http://localhost:8182/mall/userTest/showUser`;
        axios.get(url)
            .then(response => {
                // 成功了, 更新数据(成功)

                /* this.loading = false;
                 const messages  = response.data.items.map(item => ({
                     id: item.id,
                     title: item.username,

                 }))*/

                messageDetails  = response.data.data;
                //$this.messageDetails = messages;
                //alert(messages);

            })
            .catch(error => {
                // 失败了, 更新数据(失败)
                this.loading = false
                this.errorMsg = '请求失败!'
            });
      const id = this.$route.params.id;
      this.detail = messageDetails.find(detail => detail.id===id*1);

    },

    watch: {
      $route: function () { // 改变当前路由组件参数数据时自动调用
        console.log('$route()')
        const id = this.$route.params.id
        this.detail = messageDetails.find(detail => detail.id===id*1)
      }
    }
  }
</script>

<style>

</style>
