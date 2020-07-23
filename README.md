# Social-Code

<h1>Scripts</h1>
  <h6>Emily: https://docs.google.com/document/d/1GbgoDd1ZwSV6wwFKJ0kYjMJWmlma2RNlzSxNFbmfMpc/edit?usp=sharing</h6>

<h1>APIs</h1>

<h3>Calendar</h3>
  <li>Purpose:
  <em>-Ability to RSVP to posts/event</em><br>
  Documentation: <br>
  https://fullcalendar.io/ <br>
  https://developers.google.com/maps/documentation/ </li>

<h3>Email</h3>
 <em> &thinsp; mailtrap.io -testing email</em>
  
 <h6>Twilio</h6> 
 <li> Purpose:
  <em>-Ability to send out email blasts to users that have signed up for an event</em><br> 
  Documentation: <br>
  https://www.twilio.com/docs/</li>

  &thinsp;<h6>MailGun</h6>
  <li>  Purpose: - Ability to send confirmation/verification emails, for registration <br>
  Documentation: - https://documentation.mailgun.com/en/latest/</li>

<h3>Images</h3>
    <h6>Filestack</h6>
    <li>  Purpose:
    Image hosting for profile/event pictures for users <br>
    Documentation:<br>
    https://www.filestack.com/docs/</li>



<h1>Features List</h1>

<h3>First priorities</h3>
  <ul>
  <del> <li>dependencies in the pom file (spring boot)</li></del>
  <del><li>create the structure (views, controllers, models, templates, static)</li> </del> 
  <del><li>create home page (index)</li></del>
  <del><li>create the fragments</li></del> 
  <del><li>create databases</li></del>
 <del> <li>views for forms (register, login/logout, → create a post)</li></del> 
  </ul>

<h2>General</h2> (Level 1)

<h3>Security</h3>
 <del> <h5>Spring Security Config</h5></del>

<h3>Home Page</h3>(index)
  <ul>
  <del><li>Register Button</li></del>
         <li>Login Button</li> 
  <del><li>About Us section</li></del>
          <li>Teaser trailer</li> 
  </ul> 
  
  
<h3>Register Page</h3>
   <ul>
<del><li> Fields for Email</li></del> 
<del><li> Password</li> <br></del> 
<del><li> Confirm Password</li> </del> 
<del><li> First/Last Name</li></del> 
<del><li> City</li> <br></del> 
<del><li> Register Button</li> </del> 


that takes you to the welcome page...
 Checks for existing emails to avoid duplication
</ul>


<h3>Welcome Page</h3>
<ul>
  <del><li>Customized“Welcome” Message</li></del>
  <del> <li>Next steps- update(edit) profile view.</li></del>
</ul>


<h3>Profile Page</h3>
<ul>
<li>Progress bar</li>
<li>NavBar (login)- Links to Community page OR Create Post</li>
<li>Option to upload a pic (file Stack API)</li>
<li>Edit button to Bio including (Categories + Proficiencies)</li>
<li>Add professional links (GitHub, and LinkedIn) </li>
<li>Posts that user created</li>
</ul>


<h3>Login Page</h3>
<ul>
<li>When they click log out, direct to this page</li>
<li>Click Submit -> direct to community page</li>
<del><li>Forms - Email, Password</li></del>
</ul>


<h3>Create Post Page</h3>
<ul>
<del><li>Forms input Title, Date, Time, Location, Description</li></del>
<del><del><li>Drop-down menu to select Category</li></del>
<li>Click Post->(Redirect) Take them to Community Page</li></del>
</ul>


<h3>View/Edit/Delete Post Page</h3>
<ul>
<li>Form that auto populate (PrePop) contents from post ID.</li>
<li>2 Buttons Delete, Save Changes -> Redirect to the profile Page</li>
</ul>


<h3>Single User View</h3>
<ul>
<li>Use same Profile Page without update/edit button</li>
<li>Section to see the person’s posts</li>
</ul>


<h3>Single Post View </h3>
<ul>
<li>Shows Title, Description, Date, Location, Time, Link to creator’s profile page.</li>
<li>Comment section ( Button to submit)</li>
</ul>


<h3>All Users Page </h3>
<ul>
<li>Name, Pic, Location, Click name link to single view(Profile page)</li>
</ul>


<h3>Community Page/Newsfeed </h3>
<ul>
<li>Image / cards that has Title, Profile pic, Description, Date, Location</li>
<li>Button to see single Post view</li>
</ul>


<h3>NavBar (Log OUT) [Mobile]</h3>
<ul>
<li>Home (Logo)</li>
<li>About Us (4 Founders Link to Profile)</li>
<li>Register</li>
<li>Log in</li>
<li>Log Out</li>
</ul>


<h3>NavBar (Logged IN)</h3>
<ul>
<li>Home (Logo)</li>
<li>About Us (4 Founders Link to Profile)</li>
<li>Community Page</li>
<li>Search Bar</li>
<li>Create Post</li>
<li>Profile</li>
<li>Log Out</li>
</ul>




