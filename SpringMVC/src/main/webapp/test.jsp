<%@ page contentType="text/html;charset=gb2312" language="java"  %>

<!DOCTYPE html>
<html>
<head>
    <title>vue����</title>
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
</head>


<body>
<h2>Hello World!</h2>

<div id="app">
    {{ message }}
</div>

<div id="app-2">
  <span v-bind:title="message">
    �����ͣ�����Ӳ鿴�˴���̬�󶨵���ʾ��Ϣ��
  </span>
</div>

<div id="app-3">
    <p v-if="seen">�����㿴������</p>
</div>

<div id="app-4">
    <ol>
        <li v-for="todo in todos">
            {{ todo.text }}
        </li>
    </ol>
</div>

<div id="app-5">
    <p>{{ message }}</p>
    <button v-on:click="reverseMessage">��ת��Ϣ</button>
</div>

<div id="app-6">
    <p>{{ message }}</p>
    <input v-model="message">
</div>


<script>
    var app6 = new Vue({
        el: '#app-6',
        data: {
            message: 'Hello Vue!'
        }
    })


    var app5 = new Vue({
        el: '#app-5',
        data: {
            message: 'Hello Vue.js!'
        },
        methods: {
            reverseMessage: function () {
                this.message = this.message.split('').reverse().join('')
            }
        }
    })

    var app4 = new Vue({
        el: '#app-4',
        data: {
            todos: [
                { text: 'ѧϰ JavaScript' },
                { text: 'ѧϰ Vue' },
                { text: '����ţ��Ŀ' }
            ]
        }
    })

    var app3 = new Vue({
        el: '#app-3',
        data: {
            seen: true
        }
    })

    var app = new Vue({
        el: '#app',
        data: {
            message: 'Hello Vue!'
        }
    })

    var app2 = new Vue({
        el: '#app-2',
        data: {
            message: 'ҳ������� ' + new Date().toLocaleString()
        }
    })
</script>
</body>
</html>