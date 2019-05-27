<div id="filters" class="row">

    <div class="col-md-1"></div>
    <label>From</label>
    <input id="dateStartSelect" type="datetime-local" name="dateSelect" style="margin-left: 20px"
           min="2000-06-07T00:00" max="2060-06-14T00:00" onchange="dateChanged()" required>
    <label style="margin-left: 30px">To</label>
    <input id="dateFinishSelect" type="datetime-local" name="dateSelect" style="margin-left: 20px"
           min="2000-06-07T00:00" max="2060-06-14T00:00" onchange="dateChanged()" required>
    <button style="margin-left: 20px" onclick="clearDates()">Clear dates</button>

</div>