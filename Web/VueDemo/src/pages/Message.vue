<template>
  <div>
    <ul>
      <li v-for="m in messages" :key="m.id">
        <router-link :to="`/home/message/detail/${m.id}`">{{m.username}}</router-link>
        <button @click="pushShow(m.id)">push查看</button>
        <button @click="replaceShow(m.id)">replace查看</button>
      </li>
    </ul>
    <button @click="$router.back()">回退</button>
    <hr>
    <router-view></router-view>
  </div>
</template>

<script>
    import axios from 'axios'
  export default {
    data () {
      return {
        messages: [
         /* {id: 1, title: 'Message001'},
          {id: 3, title: 'Message003'},
          {id: 5, title: 'Message005'}*/
        ],

      }
    },

    mounted () {

        const url = `http://localhost:8182/mall/userTest/showUser`;
        axios.get(url)
            .then(response => {
                // 成功了, 更新数据(成功)

               /* this.loading = false;
                const messages  = response.data.items.map(item => ({
                    id: item.id,
                    title: item.username,

                }))*/
                const messages = response.data.data;
                this.messages = messages;
                alert(messages);
            })
            .catch(error => {
                // 失败了, 更新数据(失败)
                this.loading = false
                this.errorMsg = '请求失败!'
            })






    },

    methods: {
      pushShow (id) {
        this.$router.push(`/home/message/detail/${id}`)
      },

      replaceShow(id) {
        this.$router.replace(`/home/message/detail/${id}`)
      }
    }
  }
</script>

<style>

</style>
