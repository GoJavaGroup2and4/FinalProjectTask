<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Add new startup</h2>
    <br/>
    <form class="form-horizontal" action="/action_page.php">


        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Name:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="email" placeholder="Enter new startups name">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Description:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="email" placeholder="Enter new startups description">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Needed Investment:</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="email" placeholder="Enter needed investment amount">
            </div>
        </div>

        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Select Category:</label>
            <div class="col-sm-10">
                <div class="radio">
                    <label><input type="radio" name="optradio" checked>Mobile applications</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="optradio">Investment projects</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="optradio">Business (shares) for sale</label>
                </div>
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="submit" class="btn btn-primary">Cancel</button>
            </div>
        </div>


    </form>
</div>

</body>
</html>
