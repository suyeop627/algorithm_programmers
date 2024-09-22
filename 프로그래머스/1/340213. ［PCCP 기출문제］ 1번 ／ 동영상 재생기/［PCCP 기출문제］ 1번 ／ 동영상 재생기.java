import java.util.Arrays;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Video video = new Video(video_len, pos, op_start, op_end);
        Player player = new Player(video);
        
        Arrays.stream(commands).forEach(c->player.insertCommand(c));
        
        return video.getFormattedPosition();
    }
}

class Video{
    int duration;
    int position;
    int openingStart;
    int openingEnd;
    public Video(String duration, String position, String openingStart, String openingEnd){
        this.duration = convertSeconds(duration);
        this.position = convertSeconds(position);
        this.openingStart = convertSeconds(openingStart);
        this.openingEnd = convertSeconds(openingEnd);
    }
    private int convertSeconds(String time){
        String[] timeArray = time.split(":");
        return Integer.parseInt(timeArray[0])*60 + Integer.parseInt(timeArray[1]);
    }
    public String getFormattedPosition(){
        return String.format("%s:%s",addZeroIfLessThan10(position/60), addZeroIfLessThan10(position%60));
    }
    private String addZeroIfLessThan10(int time){
        return time < 10 ? "0"+time : String.valueOf(time);
    }
}

class Player{
    Video video;
    public Player(Video video){
        this.video = video;
        setPosition(video.position); //fail - 초기 값이 오프닝 중간일 경우, op_end로 이동후 명령어 실행
    }
    
    public void insertCommand(String command){
        switch (command){
            case "prev" -> goBack();
            case "next" -> goNext();    
        }
    }
    
    private void goBack(){
        int targetPosition = video.position -10 < 0 ? 0 : video.position -10;
        setPosition(targetPosition);
    }
    
    private void goNext(){
        int target = video.position +10 >video.duration ? video.duration : video.position +10;
        setPosition(target);
    }
    private void setPosition(int targetPosition){
        if(video.openingStart <= targetPosition && targetPosition <= video.openingEnd){
            video.position= video.openingEnd;
        }else{
            video.position = targetPosition;
        }
    }
    
}