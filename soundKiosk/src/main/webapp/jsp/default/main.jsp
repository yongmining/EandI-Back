<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Web Speech Recorder</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
    <p>
        <button id="startRecording">Start recording</button>
        <button id="stopRecording" disabled>Stop recording</button>
    </p>
</body>
<script>
    navigator
        .mediaDevices
        .getUserMedia({audio: true})
        .then(stream => { handlerFunction(stream) });

    function handlerFunction(stream) {
        rec = new MediaRecorder(stream);
        rec.ondataavailable = e => {
            audioChunks.push(e.data);
            if (rec.state == "inactive") {
                let blob = new Blob(audioChunks, {type: 'audio/mpeg-3'});
                sendData(blob);
            }
        }
    }

    function sendData(data) {
        var form = new FormData();
        form.append('file', data, 'data.mp3');
        form.append('title', 'data.mp3');
        //Chrome inspector shows that the post data includes a file and a title.
        $.ajax({
            type: 'POST',
            url: '/upload',
            data: form,
            cache: false,
            processData: false,
            contentType: false
        }).done(function(data) {
            console.log(data);
        });
    }

    startRecording.onclick = e => {
        console.log('Recording are started..');
        startRecording.disabled = true;
        stopRecording.disabled = false;
        audioChunks = [];
        rec.start();
    };

    stopRecording.onclick = e => {
        console.log("Recording are stopped.");
        startRecording.disabled = false;
        stopRecording.disabled = true;
        rec.stop();
    };
</script>
</html>